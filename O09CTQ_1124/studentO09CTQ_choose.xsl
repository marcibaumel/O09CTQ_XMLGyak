<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <table border="1">
                    <thead bgcolor="#baba69">
                        <tr>
                            <th>ID</th>
                            <th>Vezetkénév</th>
                            <th>Keresztnév</th>
                            <th>Becenév</th>
                            <th>Fizetés</th>
                            <th>Fokozat</th>
                        </tr>
                    </thead>
                    <tbody>
                        <xsl:apply-templates select="class/student"/>
                    </tbody>
                </table>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="class/student">
        <tr>
            <td><xsl:value-of select="@id"/></td>
            <td><xsl:value-of select="vezeteknev"/></td>
            <td><xsl:value-of select="keresztnev"/></td>
            <td><xsl:value-of select="becenev"/></td>
            <td><xsl:value-of select="fizetes"/></td>
            <xsl:choose>
                <xsl:when test="fizetes &gt; 400000">
                    <td>Magas</td>
                </xsl:when>
                <xsl:when test="fizetes &gt; 200000">
                    <td>Közepes</td>
                </xsl:when>
                <xsl:otherwise>
                    <td>Alacsony</td>
                </xsl:otherwise>
            </xsl:choose>
        </tr>
    </xsl:template>
</xsl:stylesheet>