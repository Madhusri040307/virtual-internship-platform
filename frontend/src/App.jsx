import "./App.css";

function App() {
  return (
    <div className="app">

      {/* Navbar */}
      <nav className="navbar">
        <div className="logo">
          <div className="logo-icon">VI</div>
          <div>
            <h2>VirtualIntern</h2>
            <span>Student Career Platform</span>
          </div>
        </div>

        <div className="nav-links">
          <a href="#home">Home</a>
          <a href="#internships">Internships</a>
          <a href="#features">Features</a>
          <a href="#about">About</a>
        </div>

        <div className="nav-actions">
          <button className="login-btn">Student Login</button>
          <button className="register-btn">Register</button>
        </div>
      </nav>

      {/* Hero Section */}
      <section className="hero" id="home">
        <div className="hero-content">

          <div className="badge">
            ✦ Built for Students • Learn • Apply • Grow
          </div>

          <h1>
            Start Your
            <span> Virtual Internship </span>
            Journey
          </h1>

          <p>
            Discover meaningful internship opportunities, build practical
            skills, and take the next step toward your career — all from one
            student-friendly platform.
          </p>

          <div className="hero-buttons">
            <button className="primary-btn">
              Explore Internships →
            </button>

            <button className="secondary-btn">
              Create Student Account
            </button>
          </div>

          <div className="hero-stats">
            <div>
              <strong>100+</strong>
              <span>Internships</span>
            </div>

            <div>
              <strong>500+</strong>
              <span>Students</span>
            </div>

            <div>
              <strong>50+</strong>
              <span>Companies</span>
            </div>
          </div>
        </div>

        <div className="hero-card-area">
          <div className="floating-card card-one">
            <span className="mini-icon">✓</span>
            <div>
              <strong>Application Status</strong>
              <p>Application Accepted</p>
            </div>
          </div>

          <div className="main-dashboard-card">
            <div className="dashboard-top">
              <div>
                <span>Student Dashboard</span>
                <h3>Find your opportunity</h3>
              </div>
              <div className="profile-circle">M</div>
            </div>

            <div className="search-box">
              🔍 <span>Search internships...</span>
            </div>

            <div className="internship-preview">
              <div className="company-logo">A</div>
              <div className="preview-info">
                <strong>Java Backend Intern</strong>
                <span>ABC Technologies • Chennai</span>
              </div>
              <span className="apply-label">Apply</span>
            </div>

            <div className="internship-preview">
              <div className="company-logo purple">R</div>
              <div className="preview-info">
                <strong>React Developer Intern</strong>
                <span>Rapid Solutions • Remote</span>
              </div>
              <span className="apply-label">Apply</span>
            </div>
          </div>

          <div className="floating-card card-two">
            <span className="mini-icon star">★</span>
            <div>
              <strong>Career Growth</strong>
              <p>Build real-world skills</p>
            </div>
          </div>
        </div>
      </section>

      {/* Features */}
      <section className="features-section" id="features">
        <div className="section-heading">
          <span>WHY VIRTUAL INTERN</span>
          <h2>Everything students need to get started</h2>
          <p>
            A simple platform designed to connect students with relevant
            internship opportunities.
          </p>
        </div>

        <div className="features-grid">

          <div className="feature-card">
            <div className="feature-icon blue">🔎</div>
            <h3>Find Internships</h3>
            <p>
              Search and explore internships based on your interests,
              skills and career goals.
            </p>
          </div>

          <div className="feature-card">
            <div className="feature-icon green">⚡</div>
            <h3>Easy Applications</h3>
            <p>
              Apply to internships through a simple and student-friendly
              application process.
            </p>
          </div>

          <div className="feature-card">
            <div className="feature-icon orange">📊</div>
            <h3>Track Applications</h3>
            <p>
              Monitor your applications and easily view whether they are
              applied, accepted or rejected.
            </p>
          </div>

          <div className="feature-card">
            <div className="feature-icon purple">🔐</div>
            <h3>Secure Platform</h3>
            <p>
              Student and administrator accounts are protected with secure
              authentication.
            </p>
          </div>

        </div>
      </section>

      {/* Internships */}
      <section className="internships-section" id="internships">

        <div className="section-heading">
          <span>OPPORTUNITIES</span>
          <h2>Explore popular internships</h2>
          <p>
            Start building practical experience with opportunities designed
            for students.
          </p>
        </div>

        <div className="internship-grid">

          <div className="internship-card">
            <div className="card-header">
              <div className="company-logo large">A</div>
              <span className="remote-tag">Remote</span>
            </div>

            <h3>Java Backend Intern</h3>
            <p className="company-name">ABC Technologies</p>

            <div className="job-details">
              <span>📍 Chennai</span>
              <span>⏱ 3 Months</span>
            </div>

            <button>View Internship →</button>
          </div>

          <div className="internship-card">
            <div className="card-header">
              <div className="company-logo large purple">R</div>
              <span className="remote-tag">Remote</span>
            </div>

            <h3>React Developer Intern</h3>
            <p className="company-name">Rapid Solutions</p>

            <div className="job-details">
              <span>📍 Bangalore</span>
              <span>⏱ 3 Months</span>
            </div>

            <button>View Internship →</button>
          </div>

          <div className="internship-card">
            <div className="card-header">
              <div className="company-logo large green">D</div>
              <span className="onsite-tag">On-site</span>
            </div>

            <h3>Data Analyst Intern</h3>
            <p className="company-name">DataWorks</p>

            <div className="job-details">
              <span>📍 Coimbatore</span>
              <span>⏱ 6 Months</span>
            </div>

            <button>View Internship →</button>
          </div>

        </div>
      </section>

      {/* About / CTA */}
      <section className="cta-section" id="about">
        <div>
          <span>YOUR CAREER STARTS HERE</span>
          <h2>Turn your learning into real-world experience.</h2>
          <p>
            Create your student profile, discover opportunities and take
            your first step toward professional growth.
          </p>
        </div>

        <button className="cta-button">
          Get Started →
        </button>
      </section>

      {/* Footer */}
      <footer>
        <div className="footer-main">

          <div className="footer-brand">
            <div className="logo">
              <div className="logo-icon">VI</div>
              <div>
                <h2>VirtualIntern</h2>
                <span>Student Career Platform</span>
              </div>
            </div>

            <p>
              A virtual internship platform created to help students
              discover opportunities and build practical experience.
            </p>
          </div>

          <div className="footer-column">
            <h4>Platform</h4>
            <a href="#internships">Internships</a>
            <a href="#features">Features</a>
            <a href="#home">Student Login</a>
          </div>

          <div className="footer-column">
            <h4>Project</h4>
            <a href="#about">About</a>
            <a href="#features">How It Works</a>
            <a href="#home">Contact</a>
          </div>

        </div>

        <div className="footer-bottom">
          <span>© 2026 Virtual Internship Platform for Students</span>
          <span>JJCET-Trichy • Information Technology</span>
        </div>
      </footer>

    </div>
  );
}

export default App;