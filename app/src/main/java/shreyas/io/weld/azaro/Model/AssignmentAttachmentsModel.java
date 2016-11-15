package shreyas.io.weld.azaro.Model;

/**
 * Created by shreyas on 14/11/16.
 */


/**
 * This model will store attachment details of assignments.
 * Attachments are of audio,video , pictures and text.
 */

public class AssignmentAttachmentsModel {

    private int attachmentId;
    private int assignmentId;
    private String attachmentLink;
    private String attachmentType;

    public int getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(int attachmentId) {
        this.attachmentId = attachmentId;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getAttachmentLink() {
        return attachmentLink;
    }

    public void setAttachmentLink(String attachmentLink) {
        this.attachmentLink = attachmentLink;
    }

    public String getAttachmentType() {
        return attachmentType;
    }

    public void setAttachmentType(String attachmentType) {
        this.attachmentType = attachmentType;
    }

}