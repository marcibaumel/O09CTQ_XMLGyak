<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <html>
            <body>
                <h2>MR apple- template</h2>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="student">
        <p>
            <xsl:apply-templates select="@id"/>
            <xsl:apply-templates select="vezeteknev"/>
            <xsl:apply-templates select="keresztnev"/>
            <xsl:apply-templates select="becenev"/>
            <xsl:apply-templates select="kor"/>
            <xsl:apply-templates select="fizetes"/>
        </p>
    </xsl:template>

    <xsl:template match="@id">
        ID: <xsl:value-of select="."/>
        <br/>
    </xsl:template>

    <xsl:template match="vezeteknev">
        Vezeteknev:
        <span style="color:#369a36"> <xsl:value-of select="."/></span>
        <br/>
    </xsl:template>

    <xsl:template match="keresztnev">
        Keresztnev:
        <span style="color:#bc6262"> <xsl:value-of select="."/></span>
        <br/>
    </xsl:template>

    <xsl:template match="becenev">
        <span><xsl:value-of select="."/> </span>
    </xsl:template>
    <xsl:template match="kor">
        Kor:
        <span style="color:#6b6bff"> <xsl:value-of select="."/></span>
        <br/>
    </xsl:template>
    <xsl:template match="fizetes">
        Fizetes:
        <span style="color:#ff2e2e"> <xsl:value-of select="."/></span>
        <br/>
    </xsl:template>
</xsl:stylesheet>