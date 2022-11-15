<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
   <xsl:template match="/">

      <html>

         <body>
            <h1>item</h1>
            <table border="1">
               <tr>
                  <th>title</th>
                  <th>description</th>
                  <th>link</th>
                  <th>pubDate</th>
                  <th>guid</th>
                  <th>tags</th>
               </tr>
               <xsl:for-each select="rss">
               <xsl:for-each select="channel">
               <xsl:for-each select="item">
                  <tr>
                     <td>
                        <xsl:value-of select="title" />
                     </td>
                     <td>
                        <xsl:value-of select="description" />
                     </td>
                     <td>
                        <xsl:value-of select="link" />
                     </td>
                     <td>
                        <xsl:value-of select="pubDate" />
                     </td>
                     <td>
                        <xsl:value-of select="guid" />
                     </td>
                     <td>
                        <xsl:value-of select="tags" />
                     </td>
                  </tr>
               </xsl:for-each>
               </xsl:for-each>
               </xsl:for-each>
            </table>
         </body>
      </html>
   </xsl:template>
</xsl:stylesheet>
