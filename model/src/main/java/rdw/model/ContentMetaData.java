package rdw.model;

import com.google.gson.annotations.SerializedName;

/**
 * POJO for content metadata -- the json file that accompanies the batch csv upload.
 * Its sole purpose is for de/serialization, which is why the field names don't follow java best practices,
 * some fields that should be integers are strings, etc.<br/>
 */
public class ContentMetaData {

    @SerializedName(value="Content", alternate = {"content"})
    private String Content;
    private Identification Identification;
    private Overall Overall;
    private PerformanceLevels PerformanceLevels;
    private Claims Claims;
    private ClaimsPerformanceLevel ClaimsPerformanceLevel;
    private Source Source;

    public String getContent() {
        return Content;
    }

    public ContentMetaData.Identification getIdentification() {
        return Identification;
    }

    public ContentMetaData.Overall getOverall() {
        return Overall;
    }

    public ContentMetaData.PerformanceLevels getPerformanceLevels() {
        return PerformanceLevels;
    }

    public ContentMetaData.Claims getClaims() {
        return Claims;
    }

    public ContentMetaData.ClaimsPerformanceLevel getClaimsPerformanceLevel() {
        return ClaimsPerformanceLevel;
    }

    public ContentMetaData.Source getSource() {
        return Source;
    }

    public static class Identification {
        private String Guid;
        @SerializedName(value="Year", alternate = { "AcademicYear" })  // StudentRegistration uses AcademicYear
        private Integer Year;
        private String Type;
        private String Period;          // YYYY or YYYY-01-01 or ???
        private String Version;
        private String Subject;
        private String EffectiveDate;   // YYYYMMDD

        public String getGuid() {
            return Guid;
        }

        public Integer getYear() {
            return Year;
        }

        public String getType() {
            return Type;
        }

        public String getPeriod() {
            return Period;
        }

        public String getVersion() {
            return Version;
        }

        public String getSubject() {
            return Subject;
        }

        public String getEffectiveDate() {
            return EffectiveDate;
        }
    }

    public static class Source {
        private String EmailNotification;
        private String CallbackUrl;

        public String getEmailNotification() {
            return EmailNotification;
        }

        public String getCallbackUrl() {
            return CallbackUrl;
        }
    }

    public static class Overall {
        private Integer MinScore;
        private Integer MaxScore;

        public Integer getMinScore() {
            return MinScore;
        }

        public Integer getMaxScore() {
            return MaxScore;
        }
    }

    public static class PerformanceLevels {
        private Level Level1;
        private Level Level2;
        private Level Level3;
        private Level Level4;
        private Level Level5;

        public Level getLevel1() {
            return Level1;
        }

        public Level getLevel2() {
            return Level2;
        }

        public Level getLevel3() {
            return Level3;
        }

        public Level getLevel4() {
            return Level4;
        }

        public Level getLevel5() {
            return Level5;
        }

        public static class Level {
            private String Name;
            private Integer CutPoint;

            public String getName() {
                return Name;
            }

            public Integer getCutPoint() {
                return CutPoint;
            }
        }
    }

    public static class Claims {
        private Claim Claim1;
        private Claim Claim2;
        private Claim Claim3;
        private Claim Claim4;

        public Claim getClaim1() {
            return Claim1;
        }

        public Claim getClaim2() {
            return Claim2;
        }

        public Claim getClaim3() {
            return Claim3;
        }

        public Claim getClaim4() {
            return Claim4;
        }

        public static class Claim {
            private String Name;
            private Integer MinScore;
            private Integer MaxScore;

            public String getName() {
                return Name;
            }

            public Integer getMinScore() {
                return MinScore;
            }

            public Integer getMaxScore() {
                return MaxScore;
            }
        }
    }

    public static class ClaimsPerformanceLevel {
        private Level Level1;
        private Level Level2;
        private Level Level3;

        public Level getLevel1() {
            return Level1;
        }

        public Level getLevel2() {
            return Level2;
        }

        public Level getLevel3() {
            return Level3;
        }

        public static class Level {
            private String Name;

            public String getName() {
                return Name;
            }
        }
    }
}
