package InterfacesAndAbstraction.military;
public class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {
    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName,salary);
    }
}
