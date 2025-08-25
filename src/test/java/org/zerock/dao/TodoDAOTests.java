package org.zerock.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.javaworkw2_20250825.dao.TodoDAO;
import org.zerock.javaworkw2_20250825.domain.TodoVO;


import java.time.LocalDate;
import java.util.List;

public class TodoDAOTests {
    private TodoDAO todoDAO;

    @BeforeEach
    public void ready() {
        todoDAO = new TodoDAO();
    }

    @Test
    public void testTime() throws Exception{
        System.out.println(todoDAO.getTime());
    }
    @Test
    public void testTime2() throws Exception{
        System.out.println(todoDAO.getTime2());
    }

    @Test
    public void testInsert() throws Exception {
        TodoVO todoVO = TodoVO.builder()
                .title("Sample Title...")
                .dueDate(LocalDate.of(2021, 12, 31))
                .finished(true).build();

        todoDAO.insert(todoVO);
    }

    @Test
    public void testList() throws Exception {
        List<TodoVO> list = todoDAO.selectAll();

        list.forEach(vo  -> System.out.println(vo));
    }


    @Test
    public void testSelectOne() throws Exception {
        Long tno = 1L; // 반드시 존재하는 번호를 이용;

        TodoVO vo = todoDAO.selectOne(tno);

        System.out.println(vo);

    }

    @Test
    public void testDeleteOne() throws Exception {
        Long tno = 5L;

        todoDAO.deleteOne(tno);


    }

    @Test
    public void testUpdateOnw() throws Exception {
        TodoVO todoVO = TodoVO.builder()
                .tno(1L)
                .title("Sample title...")
                .dueDate(LocalDate.of(2025,8,19))
                .finished(true)
                .build();

        todoDAO.updateOne(todoVO);
    }


}
