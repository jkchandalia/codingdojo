class Project{
    private String name;
    private String description;
    private double initialCost;

    public Project() {}

    public Project(String name) {
        this.name = name;
    }

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Project(String name, String description, double cost) {
        this.name = name;
        this.description = description;
        this.initialCost = cost;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public double getInitialCost() {
        return initialCost;
    }
    
    public void setInitialCost(double cost) {
        initialCost = cost;
    }
    
    public String elevatorPitch() {
        return name +"("+initialCost+"): "+description;
    }
}