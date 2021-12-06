
<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <ul>
                    <xsl:for-each select="autok/auto/tipus[not(.=preceding::*)]">
                        <xsl:variable name="variacio" select="text()"/>
                        <xsl:variable name="darab" select="count(//autok/auto[tipus/text()=$variacio])"/>
                        <xsl:sort select="count(.)"/>
                        <li><xsl:value-of select="$variacio"/>, ebbol: <xsl:value-of select="$darab"/>db</li>
                    </xsl:for-each>
                </ul>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>