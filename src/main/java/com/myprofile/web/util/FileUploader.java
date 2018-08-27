/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.myprofile.web.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

/**
 * @author venkatasaikiran
 * @date Apr 10, 2018 11:01:28 PM
 */
@ManagedBean(name = "FileUploader")
@ViewScoped
public class FileUploader {
    // --------------------------------------------------------------- Constants
    public static final int MAX_SIZE = 495120;
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private Part file;
    private String fileContent;

    // ------------------------------------------------------------ Constructors
    // ---------------------------------------------------------- Public Methods
    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public String getFileContent() {
        return fileContent;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

    public void uploadProfile() {
        if (fileContent != null) {
            try {
                fileContent = new Scanner(file.getInputStream())
                        .useDelimiter("\\A").next();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void validateFile(FacesContext ctx, UIComponent comp, Object value) {
        List<FacesMessage> msgs = new ArrayList<FacesMessage>();
        Part file = (Part) value;
        if (file == null) {
            msgs.add(new FacesMessage("Empty file can't be uploaded."));
        }
        if (file.getSize() > 495120) {
            msgs.add(new FacesMessage(
                    "File size is" + file.getSize() + ". file too big"));
        }
        if (!"application/vnd.openxmlformats-officedocument.wordprocessingml.document"
                .equals(file.getContentType())) {
            msgs.add(new FacesMessage("not a .docx file"));
        }
        if (!msgs.isEmpty()) {
            throw new ValidatorException(msgs);
        }
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
