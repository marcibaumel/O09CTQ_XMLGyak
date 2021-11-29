<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <xsl:value-of select="count(autok/auto[ar/text()>30000])"/>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>