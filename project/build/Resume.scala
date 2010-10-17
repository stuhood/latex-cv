import sbt._
import Process._

class ResumeProject(info: ProjectInfo) extends DefaultProject(info)
{
    def sources = "src" / "main" / "latex" * "*.tex"
    def target = "target" / "latex"

    def purge(quiet: Boolean) = FileUtilities.clean(target :: Nil, quiet, log)

    def compileLatexAction = fileTask(target from sources) {
        purge(true)
        target.asFile.mkdir
        for (source <- sources.get) {
            log.info("Compiling %s".format(source))
            val process = new java.lang.ProcessBuilder("pdflatex", source.absolutePath.toString)
            // execute the process in the working directory 'target' and log the output
            (process directory target.asFile) !! log
        }
        None
    } describedAs("Generates PDF output from LaTeX inputs.")
    lazy val latex = compileLatexAction

    def cleanLatexAction = task {
        purge(false)
        None
    } describedAs("Deletes the LaTeX output in %s.".format(target))
    lazy val cleanLatex = cleanLatexAction
    
    // compile latex on compile
    override def compileAction = super.compileAction dependsOn latex
    override def watchPaths = super.watchPaths +++ sources
    // clean latex output on clean
    override def cleanAction = super.cleanAction dependsOn cleanLatex
}
