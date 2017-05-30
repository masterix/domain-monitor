package mx;

import java.util.ArrayList;

public interface SourceInterface {
    ArrayList<DomainStatus> getDomainList() throws SourceNotFoundException;
}
