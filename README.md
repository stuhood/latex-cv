LaTeX template from http://jblevins.org/projects/cv-template/

To generate a PDF in Ubuntu 10.4, you'll need to install the following packages:
  texlive-fonts-recommended texlive-latex-base texlive-latex-extra texlive-latex-recommended
along with SBT 0.7.4 from:
  http://code.google.com/p/simple-build-tool/

Then run {{sbt latex}} to generate the output PDF in target/. The project doesn't support conditional/continual rebuilding of the PDF, but it shouldn't be hard to add.
