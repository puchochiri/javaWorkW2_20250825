package org.zerock.javaworkw2_20250825.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TodoVO {

    private Long tno;

    private String title;

    private LocalDate dueDate;

    private boolean finished;
}
