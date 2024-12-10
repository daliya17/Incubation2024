package DesignPatterns.Creational.Builder;

public class UserExam {

    // builder pattern is used to create an object in a step by step manner
    // builder pattern is used when an object cannot be created in a single step
    // builder pattern is used when an object is required to have multiple attributes
    // validation can be done in the builder pattern
    private int id;
    private int age;
    private String name;
    private int englishMarks;
    private int scienceMarks;
    private int mathsMarks;

    private UserExam() {
    }

    public static UserExamBuilder getBuilder() {
        return new UserExamBuilder();
    }

    public static class UserExamBuilder {
        private int id;
        private int age;
        private String name = "EMPTY";
        private int englishMarks;
        private int scienceMarks;
        private int mathsMarks;


        public UserExamBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public UserExamBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public UserExamBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserExamBuilder setEnglishMarks(int englishMarks) {
            this.englishMarks = englishMarks;
            return this;
        }

        public UserExamBuilder setScienceMarks(int scienceMarks) {
            this.scienceMarks = scienceMarks;
            return this;
        }

        public UserExamBuilder setMathsMarks(int mathsMarks) {
            this.mathsMarks = mathsMarks;
            return this;
        }

        public UserExam build() {
            // validate attributes
            if (this.id == 0) {
                throw new IllegalArgumentException("Id is mandatory");
            }
            if (this.age == 0) {
                throw new IllegalArgumentException("Age is mandatory");
            }
            if (this.name.equals("EMPTY")) {
                throw new IllegalArgumentException("Name is mandatory");
            }
            if (this.englishMarks == 0) {
                throw new IllegalArgumentException("English Marks is mandatory");
            }
            if (this.scienceMarks == 0) {
                throw new IllegalArgumentException("Science Marks is mandatory");
            }
            if (this.mathsMarks == 0) {
                throw new IllegalArgumentException("Maths Marks is mandatory");
            }
            UserExam userExam = new UserExam();
            userExam.age = this.age;
            userExam.id = this.id;
            userExam.name = this.name;
            userExam.englishMarks = this.englishMarks;
            userExam.scienceMarks = this.scienceMarks;
            userExam.mathsMarks = this.mathsMarks;
            return userExam;
        }
    }

}
