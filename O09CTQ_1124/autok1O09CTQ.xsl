<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <ul>
                    <xsl:apply-templates select = "autok/auto">
                        <xsl:sort select="ar" data-type="number"/>
                    </xsl:apply-templates>
                </ul>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="autok/auto">
        <li>
            <xsl:value-of select="@rsz"/>, <xsl:value-of select="ar"/>
        </li>
    </xsl:template>
</xsl:stylesheet>