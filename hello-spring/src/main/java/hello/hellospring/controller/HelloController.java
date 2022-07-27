package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "Spring!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = true) String name, Model model){ //name 이 입력된 값으로 변경(ex.Spring!!!)
        model.addAttribute("name", name); //name 이 입력된 값으로 변경(ex.Spring!!!)
        return "hello-template";
    }

    /* templete 엔진과의 차이는, view 없이 문자 그대로 들어간다는 것*/
    @GetMapping("hello-string")
    //http에는 header부분과 body부분이 있는데
    //@ResponseBody는 http의 body 부분에 return값을 직접 넣어주겠다는 뜻이다.
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; //"hello spring"
    }

//API 방식
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) { // value = spring!!!!!
        Hello hello = new Hello();
        hello.setName(name); //파라미터로 넘어온 name을 넣어줌
        return hello; //처음으로 문자가 아닌 객체를 넣어주었다.
        /* "<HTML></HTML>" //XML 방식 */
    }

    //객체 생성
    //HelloController.Hello
    static class Hello {
        //private -> 외부에서 바로 사용x
        private String name; // key = name

        //JAVA Bean 규약(표준방식) = 프로퍼티 접근 방식 = get set 방식
        //public -> 라이브러리나 자신이 사용할 때도, getName, setName과 같은 메서드들을 통해서 사용하게 된다.
        //ctrl+N -> 액션 -> getter and setter
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
