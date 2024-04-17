package net.musecom.tempwork.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class BloggerDto {
  private int id;
  private String title;
  private String content;
  private Timestamp wdate;
  private int hit;
}
