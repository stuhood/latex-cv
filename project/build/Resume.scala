import sbt._
import Process._

class ResumeProject(info: ProjectInfo) extends DefaultProject(info)
{
    def sources = "src" / "main" / "latex" * "*.tex"
    def target = path("target")

    def compileLaTeX = task {
      for (source <- sources.get) {
        log.info("Compiling %s".format(source))
        val process = new java.lang.ProcessBuilder("pdflatex", source.absolutePath.toString)
        // execute the process in the working directory 'target' and log the output
        (process directory target.asFile) ! log
      }
      None
    } describedAs("Generates PDF output from LaTeX inputs.")
    lazy val latex = compileLaTeX
}
