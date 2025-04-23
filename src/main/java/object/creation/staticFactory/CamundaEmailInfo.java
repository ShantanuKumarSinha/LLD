package object.creation.staticFactory;

// StaticFactory Method

// It is different to factory method

// Suppose you have to make CamundaEmailInfo Class from EmailInfo

// I have designed builder class here

public class CamundaEmailInfo {
  private String id;
  private String subject;
  private String sender;

  public static void main(String[] args) {
    var camundaEmailInfo =
        CamundaEmailInfo.from(
            EmailInfo.builder().id("1").subject("test").sender("test@test.com").build());
    System.out.println(camundaEmailInfo);
  }

  public static CamundaEmailInfo from(EmailInfo emailInfo) {
    // Import builder using lombok
    return CamundaEmailInfo.builder()
        .id(emailInfo.getId())
        .subject(emailInfo.getSubject())
        .sender(emailInfo.getSender())
        .build();
  }

  static CamundaEmailInfoBuilder builder() {
    return new CamundaEmailInfoBuilder();
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

  static class CamundaEmailInfoBuilder {
    static CamundaEmailInfo camundaEmailInfo = new CamundaEmailInfo();
    static CamundaEmailInfoBuilder camundaEmailInfoBuilder = new CamundaEmailInfoBuilder();

    static CamundaEmailInfoBuilder id(String id) {
      camundaEmailInfo.setId(id);
      if (camundaEmailInfoBuilder == null) {
        camundaEmailInfoBuilder = new CamundaEmailInfoBuilder();
      }
      return camundaEmailInfoBuilder;
    }

    static CamundaEmailInfoBuilder subject(String subject) {
      camundaEmailInfo.setSubject(subject);
      if (camundaEmailInfoBuilder == null) {
        camundaEmailInfoBuilder = new CamundaEmailInfoBuilder();
      }
      return camundaEmailInfoBuilder;
    }

    static CamundaEmailInfoBuilder sender(String sender) {
      camundaEmailInfo.setSender(sender);
      if (camundaEmailInfoBuilder == null) {
        camundaEmailInfoBuilder = new CamundaEmailInfoBuilder();
      }
      return camundaEmailInfoBuilder;
    }

    public CamundaEmailInfo build() {
      return camundaEmailInfo;
    }
  }
}

