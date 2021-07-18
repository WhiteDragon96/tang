package com.white.daily.design.builder;

import lombok.Data;

/**
 * 建造者模式
 *
 * @author tcs
 * @date Created in 2021-04-27
 */
@Data
public class Task {

    private Long id;
    private String name;
    private String content;
    private int type;
    private int status;

    public Task(Long id, String name, String content, int type, int status) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.type = type;
        this.status = status;
    }

    public Task(TaskBuilder taskBuilder) {
        this.id = taskBuilder.id;
        this.name = taskBuilder.name;
        this.content = taskBuilder.content;
        this.type = taskBuilder.type;
        this.status = taskBuilder.status;
    }

    public static class TaskBuilder {
        private Long id;
        private String name;
        private String content;
        private int type;
        private int status;

        public TaskBuilder(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public TaskBuilder content(String content) {
            this.content = content;
            return this;
        }

        public TaskBuilder type(int type) {
            this.type = type;
            return this;
        }

        public TaskBuilder status(int status) {
            this.status = status;
            return this;
        }

        public Task build() {
            return new Task(this);
        }
    }

}
