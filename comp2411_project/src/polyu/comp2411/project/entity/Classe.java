package polyu.comp2411.project.entity;
//it means class, or "ban ji" in Chinese. added an e to avoid name clash with java Class
public class Classe {
    private int classNo;

    public Classe(int classNo, int classTeacherId) {
        this.classNo = classNo;
        this.classTeacherId = classTeacherId;
    }

    private int classTeacherId;

    public int getClassNo() {
        return classNo;
    }

    public void setClassNo(int classNo) {
        this.classNo = classNo;
    }

    public int getClassTeacherId() {
        return classTeacherId;
    }

    public void setClassTeacherId(int classTeacherId) {
        this.classTeacherId = classTeacherId;
    }
}
