class ProjectTest{
    public static void main(String[] args){
        Project p = new Project();
        p.setName("Bridge");
        p.setDescription("Build a new bridge to help ease Bay Area traffic.");
        System.out.println(p.elevatorPitch());
        Project p2 = new Project();
        System.out.println(p2.elevatorPitch());
    }
}