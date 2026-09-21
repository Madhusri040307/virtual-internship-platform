import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import Register from "./Register";
import Login from "./Login";
import Internships from "./Internships";
import "./App.css";

function Home() {
  return (
    <>
      <section className="hero">
        <div className="hero-content">
          <span className="hero-badge">🎓 Student Career Platform</span>

          <h1>
            Start Your
            <span> Virtual Internship Journey</span>
          </h1>

          <p>
            Discover internship opportunities, apply easily, and build
            real-world skills through our student-focused virtual internship
            platform.
          </p>

          <div className="hero-buttons">
            <Link to="/internships" className="primary-btn">
              Explore Internships
            </Link>

            <Link to="/register" className="secondary-btn">
              Register Now
            </Link>
          </div>
        </div>

        <div className="hero-card">
          <div className="dashboard-header">
            <span>Student Dashboard</span>
            <span className="status-dot">●</span>
          </div>

          <div className="dashboard-item">
            <span>Java Backend Intern</span>
            <strong>Applied</strong>
          </div>

          <div className="dashboard-item">
            <span>React Developer Intern</span>
            <strong>Open</strong>
          </div>

          <div className="dashboard-item">
            <span>Data Analyst Intern</span>
            <strong>Open</strong>
          </div>
        </div>
      </section>

      <section className="stats">
        <div>
          <h2>100+</h2>
          <p>Internship Opportunities</p>
        </div>

        <div>
          <h2>500+</h2>
          <p>Student Applications</p>
        </div>

        <div>
          <h2>50+</h2>
          <p>Partner Companies</p>
        </div>
      </section>

      <section className="features">
        <div className="section-heading">
          <span>PLATFORM FEATURES</span>
          <h2>Everything Students Need</h2>
          <p>
            A simple platform designed to help students discover and manage
            their virtual internship journey.
          </p>
        </div>

        <div className="feature-grid">
          <div className="feature-card">
            <div className="feature-icon">🔍</div>
            <h3>Find Internships</h3>
            <p>
              Search and explore internship opportunities based on your
              interests and skills.
            </p>
          </div>

          <div className="feature-card">
            <div className="feature-icon">📝</div>
            <h3>Easy Applications</h3>
            <p>
              Apply for suitable internships through a simple online process.
            </p>
          </div>

          <div className="feature-card">
            <div className="feature-icon">📊</div>
            <h3>Track Applications</h3>
            <p>
              Monitor your internship applications and their current status.
            </p>
          </div>

          <div className="feature-card">
            <div className="feature-icon">🔐</div>
            <h3>Secure Platform</h3>
            <p>
              Student accounts are protected using authentication and secure
              backend services.
            </p>
          </div>
        </div>
      </section>

      <section className="internship-section">
        <div className="section-heading">
          <span>OPPORTUNITIES</span>
          <h2>Explore Internship Roles</h2>
        </div>

        <div className="internship-grid">
          <div className="internship-card">
            <span className="role-tag">Backend</span>
            <h3>Java Backend Intern</h3>
            <p>Develop REST APIs using Java and Spring Boot.</p>
            <Link to="/internships">View Internship →</Link>
          </div>

          <div className="internship-card">
            <span className="role-tag">Frontend</span>
            <h3>React Developer Intern</h3>
            <p>Build modern and responsive web applications using React.</p>
            <Link to="/internships">View Internship →</Link>
          </div>

          <div className="internship-card">
            <span className="role-tag">Data</span>
            <h3>Data Analyst Intern</h3>
            <p>Work with data analysis and business insights.</p>
            <Link to="/internships">View Internship →</Link>
          </div>
        </div>
      </section>

      <section className="cta">
        <h2>Turn Your Learning Into Real-World Experience</h2>
        <p>
          Join the Virtual Internship Platform and take the next step in your
          career journey.
        </p>

        <Link to="/register" className="primary-btn">
          Get Started
        </Link>
      </section>
    </>
  );
}

function App() {
  return (
    <BrowserRouter>
      <div className="app">
        <nav className="navbar">
          <Link to="/" className="logo">
            VirtualIntern
          </Link>

          <div className="nav-links">
            <Link to="/">Home</Link>
            <Link to="/internships">Internships</Link>
            <a href="#features">Features</a>
            <a href="#about">About</a>
          </div>

          <div className="nav-actions">
            <Link to="/login" className="login-link">
              Student Login
            </Link>

            <Link to="/register" className="register-btn">
              Register
            </Link>
          </div>
        </nav>

        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/register" element={<Register />} />
          <Route path="/login" element={<Login />} />
          <Route path="/internships" element={<Internships />} />
        </Routes>

        <footer className="footer">
          <div>
            <h3>VirtualIntern</h3>
            <p>
              Virtual Internship Platform for Students
            </p>
          </div>

          <div>
            <p>Information Technology</p>
            <p>JJCET-Trichy</p>
          </div>

          <div>
            <p>© 2026 Madhu Sri K</p>
            <p>Academic Project</p>
          </div>
        </footer>
      </div>
    </BrowserRouter>
  );
}

export default App;