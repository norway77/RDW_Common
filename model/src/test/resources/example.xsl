<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="xml" omit-xml-declaration="yes" indent="yes"/>

  <!-- identity rule copies everything by default -->
  <xsl:template match="@*|node()">
    <xsl:copy>
      <xsl:apply-templates select="@*|node()"/>
    </xsl:copy>
  </xsl:template>

  <!-- this rule changes subject="MA" to subject="Math" -->
  <xsl:template match="Test[@subject='MA']/@subject">
    <xsl:attribute name="subject">
      <xsl:value-of select="'Math'"/>
    </xsl:attribute>
  </xsl:template>

  <!-- this rule adds a leading zero to single digit grade -->
  <xsl:template match="Test/@grade[string-length()=1]">
    <xsl:attribute name="grade">
      <xsl:value-of select="'0'"/>
      <xsl:value-of select="."/>
    </xsl:attribute>
  </xsl:template>

  <!-- this rule removes the leading CA_ from school ids -->
  <xsl:template match="ExamineeRelationship[@name='SchoolID' and starts-with(@value, 'CA_')]/@value">
    <xsl:attribute name="value">
      <xsl:value-of select="substring(., 4)"/>
    </xsl:attribute>
  </xsl:template>

</xsl:stylesheet>

