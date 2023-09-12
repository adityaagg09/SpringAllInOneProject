package Base.LandingPage.Model;

import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// This annotation is very imp if not used will not map values, used at the top most parent class of the object
@XmlRootElement
public class Question {
    private int id;
    private String questionname;
    private List<Answer> answers;
    public Question() {}
    public Question(int id, String questionname, List<Answer> answers) {
        super();
        this.id = id;
        this.questionname = questionname;
        this.answers = answers;
    }
    @XmlAttribute // Thing which is attached with main tag rest is element
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @XmlElement // Used for another objects or attributes except the parent obj
    public String getQuestionname() {
        return questionname;
    }
    public void setQuestionname(String questionname) {
        this.questionname = questionname;
    }
    @XmlElement // Used for another objects or attributes except the parent obj
    public List<Answer> getAnswers() {
        return answers;
    }
    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}