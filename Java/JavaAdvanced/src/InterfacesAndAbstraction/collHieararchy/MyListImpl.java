package InterfacesAndAbstraction.collHieararchy;

public class MyListImpl extends Collection implements MyList {


    @Override
    public String remove() {
        return super.remove(false);
    }

    @Override
    public int getUsed() {
        return super.size();
    }

    @Override
    public int add(String str) {
        return super.add(str, false);
    }
}
