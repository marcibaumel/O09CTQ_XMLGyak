<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <ul>
                    <xsl:for-each select="autok/auto">
                        <xsl:choose>
                            <xsl:when test="tulaj/varos = 'Miskolc'">
                                <li>Rendszam: <xsl:value-of select="@rsz"/></li>
                            </xsl:when>
                        </xsl:choose>
                    </xsl:for-each>
                </ul>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>