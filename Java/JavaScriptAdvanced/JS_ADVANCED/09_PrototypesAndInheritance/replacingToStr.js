function toStringExtension() {
    class Person {
        constructor(name, email) {
            this.name = name;
            this.email = email;
        }
        toString() {
            let output = `${this.constructor.name} (`;
            for (const [key, value] of Object.entries(this)) {
                output += `${key}: ${value}, `;
            }
            output = output.slice(0, -2);
            output += ')';
            return output;
        }
    }
    class Student extends Person {
        constructor(name, email, course) {
            super(name, email);
            this.course = course;
        }

    }
    class Teacher extends Person {
        constructor(name, email, subject) {
            super(name, email);
            this.subject = subject;
        }

    }

    return {
        Person,
        Teacher,
        Student
    }
}