<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                 <ul>
                     <xsl:for-each select="autok/auto[tulaj/varos[not(.=preceding::*)]]">
                         <xsl:variable name="varosnev" select="tulaj/varos"/>
                         <xsl:variable name="kocsipervaros" select="count(//autok/auto[tulaj/varos=$varosnev])"/>
                         <xsl:variable name="osszar" select="sum(//autok/auto[tulaj/varos=$varosnev]/ar)"/>
                         <li>
                             Varosnev: <xsl:value-of select="$varosnev"/>
                             Kocsik szama: <xsl:value-of select="$kocsipervaros"/>
                             Ossz ar: <xsl:value-of select="$osszar"/>
                         </li>
                    </xsl:for-each>
                 </ul>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>