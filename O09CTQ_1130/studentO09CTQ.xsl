<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<body>
				<h2>Tanuló</h2>
				<table border="2">
					<tr bgcolor="green">
						<th>id</th>
						<th>Keresztnev</th>
						<th>Vezeteknev</th>
						<th>Becenev</th>
						<th>Kor</th>
					</tr>
					<xsl:for-each select="class/student">
						<tr>
							<td>
								<xsl:value-of select="@id" />
							</td>
							<td>
								<xsl:value-of select="keresztnev"/>
							</td>
							<td>
								<xsl:value-of select="vezeteknev"/>
							</td>
							<td>
								<xsl:value-of select="becenev"/>
							</td>
							<td>
								<xsl:value-of select="kor"/>
							</td>
						</tr>
					</xsl:for-each>
				</table>
				<p1>id</p1>
				<p1>Keresztnev</p1>
				<p1>Vezetéknév</p1>
				<p1>Becenév</p1>
				<p1>Kor</p1>
				
				<xsl:for-each select="class/student">
					<br></br>
					<xsl:value-of select="@id" />
					<xsl:value-of select="keresztnev"/>
					<xsl:value-of select="vezeteknev"/>
					<xsl:value-of select="becenev"/>
					<xsl:value-of select="kor"/>
					
					
				</xsl:for-each>
				
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>