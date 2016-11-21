package shreyas.io.weld.azaro.Model;

/**
 * Created by shreyas on 14/11/16.
 */

/**
 * This model is used to store attachments details of Task.
 */

public class TaskAttachment {

    private int attachmentId;
    private int taskId;
    private String attachmentLink;
    private String attachmentType;

    public int getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(int attachmentId) {
        this.attachmentId = attachmentId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
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