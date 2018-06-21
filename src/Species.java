import java.security.InvalidParameterException;

public class Species extends Node {

    public TaxonomyInfo taxon;



    public Species(TaxonomyInfo taxonInf) {
        super(taxonInf.JSONData.get("").getAsString());

        taxon = taxonInf;
    }
}
