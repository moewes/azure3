package net.moewes;

import java.util.Optional;

//import io.quarkus.security.identity.SecurityIdentity;
import net.moewes.cloudui.quarkus.runtime.identity.Identity;

public class OidcIdentity implements Identity {

  //  private SecurityIdentity identity;

    /*public OidcIdentity(SecurityIdentity identity) {

        this.identity = identity;
    }*/

    @Override
    public Optional<String> getBearer() {
        //return Optional.ofNullable(identity.getCredential(AccessTokenCredential.class).getToken());
        return Optional.empty(); // FIXME
    }
}
