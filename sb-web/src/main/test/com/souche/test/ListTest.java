package com.souche.test;

import com.souche.test.model.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by dubiao on 2017/10/28.
 */
public class ListTest {


    public static void main(String[] args) {
        // 创建集合对象
        List<Student> list = new ArrayList<Student>();

        // 创建学生对象
        Student s1 = new Student("linqingxia", 27, 1000L);
        Student s2 = new Student("风清扬", 30, 1200L);
        Student s3 = new Student("刘晓曲", 28, 2000L);
        Student s4 = new Student("武鑫", 29, 1300L);
        Student s5 = new Student("caiming", 27, 1500L);

        // 添加元素对象
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);

        // 排序
        // 自然排序
        // Collections.sort(list);
        // 比较器排序
        // 如果同时有自然排序和比较器排序，以比较器排序为主
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {

                return (int) (s1.getRate() - s2.getRate());

            }
        });

        // 遍历集合
        for (Student s : list) {
            System.out.println(s.toString());
        }
    }

}
