<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <ul>
                    <xsl:apply-templates select = "autok/auto"/>
                </ul>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="autok/auto">
        <li>
            <xsl:value-of select="@rsz"/>
        </li>
    </xsl:template>
</xsl:stylesheet>