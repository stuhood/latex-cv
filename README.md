Build environment for LaTeX files: specifically, the CV template from [http://jblevins.org/projects/cv-template/](http://jblevins.org/projects/cv-template/)

To generate PDFs in Ubuntu 10.4, you`ll need to install the following packages:
> texlive-fonts-recommended texlive-latex-base texlive-latex-extra texlive-latex-recommended

along with SBT 0.7.4 from:
> [http://code.google.com/p/simple-build-tool/](http://code.google.com/p/simple-build-tool/)

Use *sbt latex* to generate the output PDF in target/. You can also run *sbt ~latex* to have SBT watch the input LaTeX files and automatically rebuild when they change: combine with a PDF viewer that supports automatically refreshing a document for best results.
