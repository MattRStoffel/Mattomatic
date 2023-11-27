package com.mattstoffel;

import javafx.scene.image.ImageView;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HTMLFactory {
    ///to adjust for the image angle

    String title = "Mattomatic";
    String fileName = "index.html";
    String buttonImageLocation = "images/myButton.png";

    public HTMLFactory(String fileName, String title) {
        this.fileName = fileName;
        this.title = title;
    }

    public HTMLFactory(String fileName) {
        this.fileName = fileName;
    }

    public void initializeHTML(String fileName, String blueprintSrc) {
        this.fileName = fileName;
        try {
            FileWriter fwHTML = new FileWriter(fileName);
            fwHTML.write("<!DOCTYPE html>\r\n" +
                    "<html lang=\"en\">\r\n" +
                    "<head>\r\n" +
                    "  <meta charset=\"UTF-8\">\r\n" +
                    "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" +
                    "  <title>"+ title +"</title>\r\n" +
                    "  <link rel=\"stylesheet\" " +
                    "href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" \r\n" +
                    "   integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" \r\n" +
                    "   crossorigin=\"anonymous\">\r\n" +

                    "</head>\r\n" +
                    "<body>\r\n" +
                    "  <div class=\"container\">\r\n" +
//                    "    <div class=\"row\">\n" +
//                    "      <div class=\"col-3\">\n" +
//                    "      </div>\n" +
                    "      <div class=\"col-12 col-lg-5\">" +
                    "         <img class=\"w-100 h-auto\" src=\"" + blueprintSrc + "\" alt=\"\">\r\n\n");
            fwHTML.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public void initializeHTML(String blueprintSrc) {
        try {
            FileWriter fwHTML = new FileWriter(fileName);
            fwHTML.write("<!DOCTYPE html>\r\n" +
                    "<html lang=\"en\">\r\n" +
                    "<head>\r\n" +
                    "  <meta charset=\"UTF-8\">\r\n" +
                    "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" +
                    "  <title>"+ title +"</title>\r\n" +
                    "  <link rel=\"stylesheet\" " +
                    "href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" \r\n" +
                    "   integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" \r\n" +
                    "   crossorigin=\"anonymous\">\r\n" +

                    "</head>\r\n" +
                    "<body>\r\n" +
                    "  <div class=\"container \">\r\n" +
                    "    <div class=\"row\">\n" +
//                    "      <div class=\"col-3\">\n" +
//                    "      </div>\n" +
                    "      <div class=\"col-12 col-lg-12\">" +
                    "         <img class=\"w-auto vh-100\" src=\"" + blueprintSrc + "\" alt=\"\">\r\n\n");
            fwHTML.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

//    public void writeHTML(int x, int y, int angle, String imageLocation, String fileName) {
//        String number = "" + imageLocation.charAt(0) + imageLocation.charAt(1) + imageLocation.charAt(2);
//        try{
//            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
//
//            bw.write(
//                    "    <a style=\""+
//                            " position: absolute;" +
//                            " top: calc(" + y + "%);" +
//                            " left: calc(" + x + "%);" +
//                            " transform: rotate("+ (angle - 90) +"deg);\"\n" +
//                            "    	data-toggle=\"modal\" data-target=\"#modal" +
//                            number + "\">\r\n    	<image src=\"images\\button.png\" style=\"width: 1.2rem; height: 1.2rem;\"></image>\r\n    </a>\r\n\n" +
//                            "    <div class=\"modal fade\" id=\"modal"+ number +"\" role=\"dialog\">\r\n" +
//                            "      <div class=\"modal-dialog modal-lg\">\r\n" +
//                            "        <div class=\"modal-content\">\r\n" +
//                            "          <img class=\"w-100 h-auto\" src=\"images\\" + imageLocation + "\" alt=\"\">\r\n" +
//                            "        </div>\r\n" +
//                            "      </div>\r\n" +
//                            "    </div>\r\n\n");
//            bw.close();
//        }catch(Exception e){
//            System.out.println(e);
//        }
//    }
//
//    public void writeHTML(int x, int y, int angle, String imageLocation) {
//        String number = "" + imageLocation.charAt(0) + imageLocation.charAt(1) + imageLocation.charAt(2);
//        try{
//            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
//            bw.write(
//                    "    <a style=\""+
//                            " position: absolute;" +
//                            " top: calc(" + y + "%);" +
//                            " left: calc(" + x + "%);" +
//                            " transform: rotate("+ (angle) +"deg);\"\n" +
//                            "    	data-toggle=\"modal\" data-target=\"#modal" +
//                            number + "\">\r\n    	" +
//
//                            "<image src=\"" + buttonImageLocation + "\" style=\"width: 1.2rem; height: 1.2rem;\"></image>" +
//
//                            "\r\n    </a>\r\n\n" +
//                            "    <div class=\"modal fade\" id=\"modal"+ number +"\" role=\"dialog\">\r\n" +
//                            "      <div class=\"modal-dialog modal-lg\">\r\n" +
//                            "        <div class=\"modal-content\">\r\n" +
//                            "          <img class=\"w-100 h-auto\" src=\"images\\" + imageLocation + "\" alt=\"\">\r\n" +
//                            "        </div>\r\n" +
//                            "      </div>\r\n" +
//                            "    </div>\r\n\n");
//            bw.close();
//        }catch(Exception e){
//            System.out.println(e);
//        }
//    }

    public void writeHTMLByPercent(double x, double y, int angle, String imageLocation, ImageView imageView) {
        double aspectRatio = imageView.getImage().getWidth() / imageView.getImage().getHeight();
        x = (int) ((x + (Math.min(imageView.getFitWidth(), imageView.getFitHeight() * aspectRatio)/2))
                        /((Math.min(imageView.getFitWidth(), imageView.getFitHeight() * aspectRatio))/100));
        y = (int) ((y + (Math.min(imageView.getFitHeight(), imageView.getFitWidth() / aspectRatio)/2))
                /((Math.min(imageView.getFitHeight(), imageView.getFitWidth() / aspectRatio))/100));
        String number = "" + imageLocation.charAt(0) + imageLocation.charAt(1) + imageLocation.charAt(2);
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
            bw.write(
                    "    <a style=\""+
                            " position: absolute;" +
                            " top: calc(" + y + "%);" +
                            " left: calc(" + x + "%);" +
                            " transform: rotate("+ (angle - 90) +"deg);\"\n" +
                            "    	data-toggle=\"modal\" data-target=\"#modal" +
                            number + "\">\r\n    	" +

                            "<image src=\"" + buttonImageLocation + "\" style=\"width: 1.2rem; height: 1.2rem;\"></image>" +

                            "\r\n    </a>\r\n\n" +
                            "    <div class=\"modal fade\" id=\"modal"+ number +"\" role=\"dialog\">\r\n" +
                            "      <div class=\"modal-dialog modal-lg\">\r\n" +
                            "        <div class=\"modal-content\">\r\n" +
                            "          <img class=\"w-100 h-auto\" src=\"images\\" + imageLocation + "\" alt=\"\">\r\n" +
                            "        </div>\r\n" +
                            "      </div>\r\n" +
                            "    </div>\r\n\n");
            bw.close();
        }catch(Exception e){
            System.out.println(e);
        }
        System.out.println(x + ' ' + y + ' ' + angle + ' ' + imageLocation );
    }

//    public void closeHTML(String fileName) {
//        try {
//            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
//            bw.write("\r\n" +
////                    "    <div class=\"col-3\">\n" +
////                    "    </div>\n" +
//                    "  </div>\r\n" +
//                    "<script src=\"https://code.jquery.com/jquery-3.4.1.slim.min.js\" \r\n" +
//                    "   integrity=\"sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n\" \r\n" +
//                    "   crossorigin=\"anonymous\"></script>\r\n" +
//                    "<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\" \r\n" +
//                    "   integrity=\"sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo\" \r\n" +
//                    "   crossorigin=\"anonymous\"></script>\r\n" +
//                    "<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\" \r\n" +
//                    "   integrity=\"sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6\" \r\n" +
//                    "   crossorigin=\"anonymous\"></script>\r\n" +
//                    "</iframe>\r\n" +
//                    "</body>\r\n" +
//                    "</html>");
//            bw.close();
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }
//    }

    public void closeHTML() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
            bw.write("\r\n" +
//                    "    <div class=\"col-3\">\n" +
//                    "    </div>\n" +
                    "  </div>\r\n" +
                    "<script src=\"https://code.jquery.com/jquery-3.4.1.slim.min.js\" \r\n" +
                    "   integrity=\"sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n\" \r\n" +
                    "   crossorigin=\"anonymous\"></script>\r\n" +
                    "<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\" \r\n" +
                    "   integrity=\"sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo\" \r\n" +
                    "   crossorigin=\"anonymous\"></script>\r\n" +
                    "<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\" \r\n" +
                    "   integrity=\"sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6\" \r\n" +
                    "   crossorigin=\"anonymous\"></script>\r\n" +
                    "</iframe>\r\n" +
                    "</body>\r\n" +
                    "</html>");
            bw.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public void openInBrowser(String fileName) {
        if(Desktop.isDesktopSupported()){
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(fileName));
            } catch (IOException | URISyntaxException e2) {
                e2.printStackTrace();
            }
        }else{
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("xdg-open " + fileName);
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }

    public void openInBrowser() throws IOException {
        File htmlFile = new File(fileName);
        Desktop.getDesktop().browse(htmlFile.toURI());
    }
}
