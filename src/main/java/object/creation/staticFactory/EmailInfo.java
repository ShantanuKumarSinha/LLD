package object.creation.staticFactory;

public class EmailInfo {
  private String id;
  private String subject;
  private String sender;

  public static EmailInfoBuilder builder() {
    return new EmailInfoBuilder();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getSender() {
    return sender;
  }

  public void setSender(String sender) {
    this.sender = sender;
  }

  static class EmailInfoBuilder {
    static EmailInfo emailInfo = new EmailInfo();
    static EmailInfoBuilder emailInfoBuilder = new EmailInfoBuilder();

    static EmailInfoBuilder id(String id) {
      emailInfo.setId(id);
      if (emailInfoBuilder == null) {
        emailInfoBuilder = new EmailInfoBuilder();
      }
      return emailInfoBuilder;
    }

    static EmailInfoBuilder subject(String subject) {
      emailInfo.setSubject(subject);
      if (emailInfoBuilder == null) {
        emailInfoBuilder = new EmailInfoBuilder();
      }
      return emailInfoBuilder;
    }

    static EmailInfoBuilder sender(String sender) {
      emailInfo.setSender(sender);
      if (emailInfoBuilder == null) {
        emailInfoBuilder = new EmailInfoBuilder();
      }
      return emailInfoBuilder;
    }

    public EmailInfo build() {
      return emailInfo;
    }
  }
}
