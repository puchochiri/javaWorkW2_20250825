package org.zerock.javaworkw2_20250825.domain;

import lombok.*;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {
  private String mid;
  private String mpw;
  private String mname;
  private String uuid;

}
