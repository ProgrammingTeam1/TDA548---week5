package assignments.product;

/*
 *  Representing the man
 */

public class Man {

   // TODO

    private int nParts;

    // Parts of the hanging man (\n is the new line character)
    private final String[] parts = {
            "---|\n",
            "   |\n",
            "   O\n",
            "  /",
            "|",
            "\\\n",
            "  /",
            " \\\n",
    };

    public Man(){
        nParts = 0;
    }

    public void addPart(){
        nParts++;
    }
    public boolean isFull(){
        return nParts == parts.length;
    }


    public String toString(){

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < nParts) {
            sb.append(parts[i]);
            i++;
        }
        return sb.toString();

    }

}