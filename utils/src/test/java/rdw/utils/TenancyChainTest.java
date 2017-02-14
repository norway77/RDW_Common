package rdw.utils;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TenancyChainTest {

    @Test
    public void itShouldSupportAnEmptyChain() {
        final String value = "";
        final TenancyChain chain = TenancyChain.fromString(value);
        assertThat(chain.isEmpty()).isTrue();
        assertThat(chain.toString()).isEqualTo(value);
    }

    @Test
    public void itShouldSupportASimpleClientGrant() {
        final String value = "||ASMTDATALOAD|||SBAC|||||||||||||";
        final TenancyChain chain = TenancyChain.fromString(value);
        assertThat(chain.hasRole("ASMTDATALOAD")).isTrue();
        assertThat(chain.toString()).isEqualTo(value);
    }

    @Test
    public void itShouldSupportMultipleRolesStateGrant() {
        final String value = "|CA|SAREXTRACTS|STATE|98765|CA98765|||CA|CALIFORNIA|||||||||,|CA|AUDITXML|STATE|98765|CA98765|||CA|CALIFORNIA|||||||||,|CA|SRCEXTRACTS|STATE|98765|CA98765|||CA|CALIFORNIA|||||||||,|CA|GENERAL|STATE|98765|CA98765|||CA|CALIFORNIA|||||||||,|CA|ASMTDATALOAD|STATE|98765|CA98765|||CA|CALIFORNIA|||||||||,|CA|SRSEXTRACTS|STATE|98765|CA98765|||CA|CALIFORNIA|||||||||,|CA|PII|STATE|98765|CA98765|||CA|CALIFORNIA|||||||||,|CA|ALLSTATES|STATE|98765|CA98765|||CA|CALIFORNIA|||||||||,|CA|IIRDEXTRACTS|STATE|98765|CA98765|||CA|CALIFORNIA|||||||||";
        final TenancyChain chain = TenancyChain.fromString(value);
        assertThat(chain.hasRoleForState("SAREXTRACTS", "CA")).isTrue();
        assertThat(chain.hasRoleForState("AUDITXML", "CALIFORNIA")).isTrue();
        assertThat(chain.hasRoleForState("GENERAL", "CA")).isTrue();
        assertThat(chain.hasRole("ASMTDATALOAD"));
        assertThat(chain.toString()).isEqualTo(value);
    }

    @Test
    public void itShouldSupportMultipeRolesMultipleLevels() {
        final String value = "|CA|Administrator|STATE|98765|CA98765|||CA|CALIFORNIA|||||||||,|DS9002|Test Admininistrator|INSTITUTION|98765|CA98765|||CA|CALIFORNIA|||DISTRICT2|District 2 - San Diego|||DS9002|San Diego Institution|,|DISTRICT2|Administrator|DISTRICT|98765|CA98765|||CA|CALIFORNIA|||DISTRICT2|District 2 - San Diego|||||";
        final TenancyChain chain = TenancyChain.fromString(value);
        assertThat(chain.hasRoleForState("Administrator", "CA")).isTrue();
        assertThat(chain.hasRoleForState("Test Administrator", "CA")).isFalse();
        assertThat(chain.toString()).isEqualTo(value);
    }


    @Test(expected = IllegalArgumentException.class)
    public void itShouldRejectIfTooShort() {
        TenancyChain.fromString("||PII|");
    }

    @Test(expected = IllegalArgumentException.class)
    public void itShouldRejectIfTooShortForStateLevel() {
        TenancyChain.fromString("||GENERAL|STATE||SBAC|");
    }

    @Test(expected = IllegalArgumentException.class)
    public void itShouldRejectIfTooShortForDistrictLevel() {
        TenancyChain.fromString("||GENERAL|DISTRICT|||||CA||");
    }

    @Test(expected = IllegalArgumentException.class)
    public void itShouldRejectIfTooShortForInstitutionLevel() {
        TenancyChain.fromString("||GENERAL|INSTITUTION|||||CA||DS9001||");
    }
}
