import java.util.ArrayList;
import java.util.Arrays;

class Portfolio{
    private ArrayList<Project> projects;

    public Portfolio() {
        this.projects = new ArrayList<Project>();
    }

    public Portfolio(ArrayList<Project> projects){
        this.projects = projects;
    }

    public void addProject(Project project){
        this.projects.add(project);
    }

    public ArrayList<Project> getProjects(){
        return projects;
    }
    public void setProjects(ArrayList<Project> projects){
        this.projects = projects;
    }
    public double getPortfolioCost(){
        double totalCost = 0;
        for (Project p:projects){
            totalCost += p.getInitialCost();
        }
        return totalCost;
    }
    public void showPortfolio(){
        for (Project p:projects){
            System.out.println(p.elevatorPitch());
        }
    }
}