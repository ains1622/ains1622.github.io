function processExcel() {
    const fileUpload = document.getElementById('fileUpload');
    const reader = new FileReader();
  
    reader.onload = function (e) {
      const data = new Uint8Array(e.target.result);
      const workbook = XLSX.read(data, { type: 'array' });
  
      const output = document.getElementById('output');
      output.innerHTML = '';
  
      // Procesar cada hoja del archivo Excel
      workbook.SheetNames.forEach(sheetName => {
        const worksheet = workbook.Sheets[sheetName];
        const jsonData = XLSX.utils.sheet_to_json(worksheet, { header: 1 });
  
        // Mostrar los datos de la hoja en la página
        const table = document.createElement('table');
        jsonData.forEach(row => {
          const tr = document.createElement('tr');
          row.forEach(cell => {
            const td = document.createElement('td');
            td.textContent = cell;
            tr.appendChild(td);
          });
          table.appendChild(tr);
        });
  
        const sheetTitle = document.createElement('h2');
        sheetTitle.textContent = sheetName;
        output.appendChild(sheetTitle);
        output.appendChild(table);
      });
    };
  
    reader.readAsArrayBuffer(fileUpload.files[0]);
  }
  
  function s2ab(s) {
    const buf = new ArrayBuffer(s.length);
    const view = new Uint8Array(buf);
    for (let i = 0; i < s.length; i++) view[i] = s.charCodeAt(i) & 0xff;
    return buf;
  }
  