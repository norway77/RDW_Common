package rdw.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Helper for manipulating user tenancy chain
 * <p>
 * Dug up from python code (python code uses only fields 1,7,8,11,15), format of string in sbac chain:<pre>
 0      1    2     3        4      5              6             7       8     9                  10               11         12       13                    14                  15            16
|RoleId|Name|Level|ClientID|Client|GroupOfStateID|GroupOfStates|StateID|State|GroupOfDistrictsID|GroupOfDistricts|DistrictID|District|GroupOfInstitutionsID|GroupOfInstitutions|InstitutionID|Institution|</pre>
 * where<ul>
 *     <li>RoleId - ???, e.g. CA</li>
 *     <li>Name - name of role, e.g. GENERAL, PII, ASMTDATALOAD</li>
 *     <li>Level - grant level, e.g. STATE, DISTRICT, INSTITUTION</li>
 *     <li>ClientID - client id, e.g. CA</li>
 *     <li>Client - client name, e.g. SBAC, CA98765</li>
 *     <li>GroupOfStateID</li>
 *     <li>GroupOfStates</li>
 *     <li>StateID - state id, e.g. CA</li>
 *     <li>State - state name, e.g. CALIFORNIA</li>
 *     <li>GroupOfDistrictsID</li>
 *     <li>GroupOfDistricts</li>
 *     <li>DistrictID - district id, e.g. DISTRICT2, 2ce72d77-1de2-4137-a083-77935831b817</li>
 *     <li>District - district name, e.g. Dealfish Pademelon SD</li>
 *     <li>GroupOfInstitutionsID</li>
 *     <li>GroupOfInstitutions</li>
 *     <li>InstitutionID - school id, e.g. 942, DS9001</li>
 *     <li>Institution - school name, e.g. Daybreak Central High</li>
 * </ul>
 * Multiple chains can be indicated, comma separated.
 * </p>
 */
public class TenancyChain {

    private List<Grant> grants;

    private TenancyChain(final List<Grant> grants) {
        this.grants = grants;
    }

    /**
     * Parses a full tenancy chain string returning a new instance
     *
     * @param value chain to parse
     * @return newly created tenancy chain
     */
    public static TenancyChain fromString(final String value) {
        final ArrayList<Grant> grants = new ArrayList<>();

        if (value == null || value.isEmpty()) {
            return new TenancyChain(grants);
        }

        for (final String grant : value.split(",")) {
            if (grant.isEmpty()) continue;
            grants.add(Grant.fromString(grant));
        }

        return new TenancyChain(grants);
    }

    public String toString() {
        return String.join(",", grants.stream().map(Grant::toString).collect(Collectors.toList()));
    }

    public boolean isEmpty() {
        return grants.isEmpty();
    }

    /**
     * This method returns true if the role is granted at any level.<br/>
     * This should go away since it is not specific enough; perhaps replaced by
     * hasRoleForClient or hasRoleForState; but it is currently being used by
     * exam service.
     *
     * @param roleName role name, e.g. "ASMTDATALOAD"; case is ignored
     * @return true if role is granted at any level
     */
    public boolean hasRole(final String roleName) {
        return grants.stream().map(Grant::getRoleName).anyMatch(roleName::equalsIgnoreCase);
    }

    /**
     * Return true if the role is granted for the state.
     *
     * @param role role id or name
     * @param state state id or name
     * @return true if role is granted for given state
     */
    public boolean hasRoleForState(final String role, final String state) {
        return grants.stream().anyMatch(grant ->
                   (role.equalsIgnoreCase(grant.getRoleId()) || role.equalsIgnoreCase(grant.getRoleName()))
                && (state.equalsIgnoreCase(grant.getStateId()) || state.equalsIgnoreCase(grant.getStateName()))
                && (grant.getLevel().isEmpty() || grant.getLevel().equalsIgnoreCase("STATE")));
    }


    public static class Grant {
        private static final int idxRoleId = 1;
        private static final int idxRoleName = 2;
        private static final int idxLevel = 3;
        private static final int idxClientId = 4;
        private static final int idxClientName = 5;
        private static final int idxStateId = 8;
        private static final int idxStateName = 9;
        private static final int idxDistrictId = 12;
        private static final int idxDistrictName = 13;
        private static final int idxSchoolId = 16;
        private static final int idxSchoolName = 17;

        private final String[] tokens;

        private Grant(final String[] tokens) {
            this.tokens = tokens;
        }

        public static Grant fromString(final String value) {
            final String[] tokens = value.split("\\|", -1);
            if (tokens.length <= idxClientId
             || (tokens.length <= idxStateId && tokens[idxLevel].equalsIgnoreCase("STATE"))
             || (tokens.length <= idxDistrictId && tokens[idxLevel].equalsIgnoreCase("DISTRICT"))
             || (tokens.length <= idxSchoolId && tokens[idxLevel].equalsIgnoreCase("INSTITUTION"))) {
                throw new IllegalArgumentException("invalid tenancy chain " + value);
            }

            // TODO - is there an implied grant level if state/district/school values are set?

            return new Grant(tokens);
        }

        public String toString() {
            return String.join("|", tokens);
        }

        public String getRoleId() {
            return tokens[idxRoleId];
        }

        public String getRoleName() {
            return tokens[idxRoleName];
        }

        public String getLevel() {
            return tokens[idxLevel];
        }

        public String getClientId() {
            return tokens[idxClientId];
        }

        public String getClientName() {
            return tokens[idxClientName];
        }

        public String getStateId() {
            return tokens[idxStateId];
        }

        public String getStateName() {
            return tokens[idxStateName];
        }

        public String getDistrictId() {
            return tokens[idxDistrictId];
        }

        public String getDistrictName() {
            return tokens[idxDistrictName];
        }

        public String getSchoolId() {
            return tokens[idxSchoolId];
        }

        public String getSchoolName() {
            return tokens[idxSchoolName];
        }
    }
}
