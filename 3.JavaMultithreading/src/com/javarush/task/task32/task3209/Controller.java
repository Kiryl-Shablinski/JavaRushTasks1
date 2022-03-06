package com.javarush.task.task32.task3209;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

public class Controller {

    private View view;
    private HTMLDocument document;
    private File currentFile;


    public Controller (View view){
        this.view = view;
    }

    public HTMLDocument getDocument() {
        return document;
    }

    public void init(){
        createNewDocument();
    }

    public void exit(){
        System.exit(0);
    }

    public static void main(String[] args) {
       View view1 = new View();
       Controller controller = new Controller(view1);
       view1.setController(controller);
       view1.init();
       controller.init();

    }

    public void resetDocument(){

        if (document != null) {
            document.removeUndoableEditListener(view.getUndoListener());
        }

            HTMLEditorKit kit = new HTMLEditorKit();
            document = (HTMLDocument) kit.createDefaultDocument();
            document.addUndoableEditListener(view.getUndoListener());
            view.update();

    }

    public void setPlainText( String text){
        resetDocument();
        StringReader reader = new StringReader(text);
        HTMLEditorKit kit = new HTMLEditorKit();
        try {
           kit.read(reader,document,0);
        }catch (Exception exception){
            ExceptionHandler.log(exception);
        }
    }

    public String getPlainText(){
        StringWriter writer = new StringWriter();
        HTMLEditorKit kit = new HTMLEditorKit();
        try{
            kit.write(writer,document,0, document.getLength());

        }catch (Exception exception){
            ExceptionHandler.log(exception);
        }
        return writer.toString();
    }

    public void createNewDocument(){
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        currentFile = null;
    }

    public void openDocument(){
        view.selectHtmlTab();
        JFileChooser jFile = new JFileChooser();
        jFile.setFileFilter(new HTMLFileFilter());
        int result = jFile.showOpenDialog(view);
        if (result == JFileChooser.APPROVE_OPTION) {
            currentFile = jFile.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());
            try (FileReader reader = new FileReader(currentFile)) {
                HTMLEditorKit kit = new HTMLEditorKit();
                kit.read(reader, document, 0);
                view.resetUndo();
            } catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }

    }

    public void saveDocument(){
        view.selectHtmlTab();

        if (currentFile != null){
            try(FileWriter writer = new FileWriter(currentFile)){
                HTMLEditorKit kit = new HTMLEditorKit();
                kit.write(writer,document,0,document.getLength());

            }catch (Exception e){
                ExceptionHandler.log(e);
            }
        }else{
            saveDocumentAs();
        }
    }

    public void saveDocumentAs(){
        view.selectHtmlTab();
        JFileChooser jFile = new JFileChooser();
        jFile.setFileFilter(new HTMLFileFilter());
        int result = jFile.showSaveDialog(view);
        if (result == JFileChooser.APPROVE_OPTION){
            currentFile = jFile.getSelectedFile();
            view.setTitle(currentFile.getName());
            try(FileWriter writer = new FileWriter(currentFile)){
                HTMLEditorKit kit = new HTMLEditorKit();
                kit.write(writer,document,0,document.getLength());

            }catch (Exception e){
                ExceptionHandler.log(e);
            }
        }

    }
}
