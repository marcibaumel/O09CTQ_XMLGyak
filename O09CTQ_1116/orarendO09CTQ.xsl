<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <hr>2021/22. I.félév</hr>
                <table border="1">
                    <thead>
                        <tr bgcolor="#f8154b">
                            <th>Tárgy</th>
                            <th>ID</th>
                            <th>Típus</th>
                            <th>Időpont</th>
                            <th>Helyszín</th>
                            <th>Oktató</th>
                            <th>Szak</th>
                        </tr>
                    </thead>
                    <tbody>
                        <xsl:for-each select="orarend/ora">
                            <tr>
                                <td><xsl:value-of select="targy"/></td>
                                <td><xsl:value-of select="@id"/></td>
                                <td><xsl:value-of select="@tipus"/></td>
                                <td><xsl:value-of select="idopont/nap"/>, <xsl:value-of select="idopont/tol"/>-<xsl:value-of select="idopont/ig"/></td>
                                <td><xsl:value-of select="helyszin"/></td>
                                <td><xsl:value-of select="oktato"/></td>
                                <td><xsl:value-of select="szak"/></td>
                            </tr>
                        </xsl:for-each>
                    </tbody>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>