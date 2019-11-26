class PortfolioTest{
    public static void main(String[] args){
        Portfolio p = new Portfolio();
        Project project = new Project("Bridge", "Build bridge.");
        p.addProject(project);
        p.showPortfolio();

    }
}