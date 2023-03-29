package study.bMart.dto;


import lombok.*;
import study.bMart.entity.Category;


public class CategoryDto {
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public static class Request {
        private Long id;
        private String title;
        public Category toEntity(){

            return  Category.builder().title(title).build();
        }
    }
    @Getter
    @Setter
    public static class Response {

        private Long id;
        private String title;

        public Response(Category category){
            this.id = category.getId();
            this.title = category.getTitle();
        }
        public Category Update(){
            return Category.builder().title(title).build();
        }
    }
}

