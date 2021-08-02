package InterfacesAndAbstraction.military;
import java.util.ArrayList;
import java.util.Collection;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private Collection<Private> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
    }


    @Override
    public void addPrivate(Private priv) {
        this.privates.add(priv);

    }
}
