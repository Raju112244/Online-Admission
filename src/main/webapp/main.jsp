<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Raj University | Student Hub</title>
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=DM+Sans:wght@400;500;600;700&family=Space+Grotesk:wght@500;600;700&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="assets/app.css">
  <script crossorigin src="https://unpkg.com/react@18/umd/react.development.js"></script>
  <script crossorigin src="https://unpkg.com/react-dom@18/umd/react-dom.development.js"></script>
  <script src="https://unpkg.com/@babel/standalone/babel.min.js"></script>
</head>
<body>
  <div id="student-hub"></div>
  <script type="text/babel">
    const { useState } = React;
    const subjects = [
      { code: 'CS 301', name: 'Data Structures', faculty: 'Dr. Meera Shah', present: 28, total: 30, tone: 'mint' },
      { code: 'CS 302', name: 'Database Systems', faculty: 'Prof. Arjun Rao', present: 24, total: 28, tone: 'blue' },
      { code: 'CS 303', name: 'Operating Systems', faculty: 'Dr. Neha Kapoor', present: 22, total: 26, tone: 'amber' },
      { code: 'CS 304', name: 'Web Technologies', faculty: 'Prof. Kunal Verma', present: 25, total: 27, tone: 'violet' }
    ];
    const results = [
      { code: 'CS 201', name: 'Object Oriented Programming', credits: 4, grade: 'A', points: '9.0' },
      { code: 'CS 202', name: 'Computer Networks', credits: 4, grade: 'A-', points: '8.5' },
      { code: 'MA 204', name: 'Discrete Mathematics', credits: 3, grade: 'B+', points: '8.0' },
      { code: 'HU 205', name: 'Professional Communication', credits: 2, grade: 'A', points: '9.0' }
    ];
    const pct = item => Math.round(item.present / item.total * 100);
    function Sidebar({ active, setActive }) {
      const links = [['overview', 'Overview'], ['attendance', 'Attendance'], ['results', 'Semester results'], ['materials', 'Class materials']];
      return <aside className="sidebar"><div className="brand"><span className="brand-mark">R</span><span>raj<span className="brand-muted">university</span></span></div><div className="student-mini"><div className="avatar">AS</div><div><strong>Arjun Sharma</strong><small>CS · Semester 4</small></div></div><nav>{links.map(([id, label]) => <button key={id} className={active === id ? 'nav-link active' : 'nav-link'} onClick={() => setActive(id)}><span className={'nav-icon icon-' + id}></span>{label}</button>)}</nav><div className="sidebar-bottom"><a href="contact.jsp" className="help-link"><span>?</span> Need help?</a><a href="index.jsp" className="sign-out">Sign out</a></div></aside>;
    }
    function SubjectRows() { return <>{subjects.map(subject => <div className="subject-row" key={subject.code}><div className={'subject-icon ' + subject.tone}>{subject.code.slice(-1)}</div><div className="subject-info"><div><strong>{subject.name}</strong><small>{subject.code} · {subject.faculty}</small></div><div className="subject-percent"><b>{pct(subject)}%</b><span>{subject.present}/{subject.total} classes</span></div></div><div className="progress subject-progress"><i className={pct(subject) < 85 ? 'low' : ''} style={{ width: pct(subject) + '%' }}></i></div></div>)}</>; }
    function Overview({ setActive }) {
      return <><section className="hero-card"><div><span className="eyebrow">MONDAY, 05 SEPTEMBER 2026</span><h1>Good morning, Arjun<span className="coral">.</span></h1><p>Stay on top of your semester. You are doing great this week.</p></div><div className="hero-shape"><span>4.0</span><small>current GPA</small></div></section><div className="section-heading"><div><span className="eyebrow">YOUR ACADEMIC SNAPSHOT</span><h2>Keep your momentum</h2></div><button className="text-button" onClick={() => setActive('attendance')}>View attendance <span>→</span></button></div><section className="metric-grid"><div className="metric-card"><div className="metric-top"><span className="metric-icon">◔</span><span className="status-chip positive">On track</span></div><strong>88<span>%</span></strong><p>Overall attendance</p><div className="progress"><i style={{ width: '88%' }}></i></div><small>Need 2 more classes to reach 90%</small></div><div className="metric-card"><div className="metric-top"><span className="metric-icon blue-icon">▣</span><span className="status-chip">This term</span></div><strong>4.0</strong><p>Semester GPA</p><div className="grade-row"><span>Last semester</span><b>3.8 <em>+0.2</em></b></div></div><div className="metric-card"><div className="metric-top"><span className="metric-icon amber-icon">⌁</span><span className="status-chip warning">2 due soon</span></div><strong>06</strong><p>Upcoming classes</p><div className="grade-row"><span>Next class</span><b>10:30 AM</b></div></div></section><div className="content-grid"><section className="panel attendance-panel"><div className="panel-heading"><div><span className="eyebrow">ATTENDANCE</span><h2>Subject performance</h2></div><button className="select-button">This semester <span>⌄</span></button></div><SubjectRows /></section><section className="panel schedule-panel"><div className="panel-heading"><div><span className="eyebrow">TODAY</span><h2>Class schedule</h2></div><button className="circle-button">↗</button></div><div className="date-strip"><b>05</b><span>SEP<br/><small>MON</small></span></div><div className="class-item current"><div className="time">10:30<br/><small>AM</small></div><div><strong>Data Structures</strong><span>Room A-204 · Dr. Meera Shah</span></div><i>Now</i></div><div className="class-item"><div className="time">02:00<br/><small>PM</small></div><div><strong>Operating Systems</strong><span>Lab B-102 · Dr. Neha Kapoor</span></div></div><button className="outline-button" onClick={() => setActive('materials')}>Open class materials</button></section></div></>;
    }
    function Results() { return <section className="results-view"><div className="results-banner"><div><span className="eyebrow">ACADEMIC RECORD</span><h1>Semester results</h1><p>Your progress, clearly laid out.</p></div><div className="gpa-badge"><small>SEMESTER GPA</small><strong>4.0</strong><span>Excellent standing</span></div></div><div className="result-summary"><div><span>Credits earned</span><strong>13 / 20</strong></div><div><span>Class rank</span><strong>08 <small>of 64</small></strong></div><div><span>Attendance bonus</span><strong className="green-text">+0.2</strong></div></div><section className="panel result-table"><div className="panel-heading"><div><span className="eyebrow">SEMESTER 3 · 2025–26</span><h2>Course grades</h2></div><button className="outline-button download">↓ Download transcript</button></div><div className="table-head"><span>COURSE</span><span>CREDITS</span><span>GRADE</span><span>POINTS</span></div>{results.map(result => <div className="result-row" key={result.code}><div><strong>{result.name}</strong><small>{result.code}</small></div><span>{result.credits}</span><b className={result.grade === 'B+' ? 'grade grade-average' : 'grade'}>{result.grade}</b><span>{result.points}</span></div>)}</section></section>; }
    function Placeholder({ active }) { return <section className="empty-view"><span className="empty-icon">{active === 'materials' ? '▤' : '◔'}</span><span className="eyebrow">COMING UP</span><h1>{active === 'materials' ? 'Class materials' : 'Attendance detail'}</h1><p>This view is ready for your course data and will connect to the Java backend next.</p><button className="outline-button">Explore dashboard</button></section>; }
    function App() { const [active, setActive] = useState('overview'); return <div className="app-shell"><Sidebar active={active} setActive={setActive}/><main className="main-content"><header className="topbar"><button className="mobile-menu">☰</button><div className="breadcrumb">Student portal <span>/</span> <b>{active === 'overview' ? 'Overview' : active[0].toUpperCase() + active.slice(1)}</b></div><div className="top-actions"><button className="notification">♧<i></i></button><div className="top-avatar">AS</div></div></header><div className="page-content">{active === 'overview' && <Overview setActive={setActive}/>} {active === 'results' && <Results/>} {active === 'attendance' && <><div className="section-heading standalone"><div><span className="eyebrow">ATTENDANCE OVERVIEW</span><h1>Every class counts.</h1></div></div><Overview setActive={setActive}/></>} {active === 'materials' && <Placeholder active={active}/>}</div></main></div>; }
+    ReactDOM.createRoot(document.getElementById('student-hub')).render(<App />);
+  </script>
+</body>
+</html>
