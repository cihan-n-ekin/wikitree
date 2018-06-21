import java.security.InvalidParameterException;

public class Species extends Node {

    public TaxonomyInfo taxon;



    public Species(TaxonomyInfo taxonInf) {
        super(taxonInf.species.get("scientificName").getAsString());
        taxon = taxonInf;
    }

    public void setTree() {

    }
}
